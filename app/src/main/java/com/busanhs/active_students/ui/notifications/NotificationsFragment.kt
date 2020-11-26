package com.busanhs.active_students.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.busanhs.active_students.R
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import java.lang.Integer.parseInt

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        val scanBtn: ImageButton = root.findViewById(R.id.btn_notifications_scan)
        val gradeSpinner: Spinner = root.findViewById(R.id.spn_notifications_grade)
        val teBan: EditText = root.findViewById(R.id.et_notifications_ban)
        val teNum: EditText = root.findViewById(R.id.et_notifications_num)
        val teName: EditText = root.findViewById(R.id.et_notifications_name)
        val merit: TextView = root.findViewById(R.id.tv_notifications_merit_text)
        scanBtn.setOnClickListener {
            val grade = gradeSpinner.selectedItem.toString().subSequence(0, 1).toString()
            val ban = teBan.text.toString()
            val num = teNum.text.toString()
            val name = teName.text.toString()
            if (grade.isNotEmpty() && ban.isNotEmpty() && num.isNotEmpty() && name.isNotEmpty()) {
                notificationsViewModel.setRequestData(
                    NotificationsViewModel.RequestDataFormat(
                        parseInt(grade),
                        parseInt(ban),
                        parseInt(num),
                        name
                    )
                )
                IntentIntegrator
                    .forSupportFragment(this)
                    .setBeepEnabled(false)
                    .setOrientationLocked(false)
                    .setPrompt("학생증 뒷면 바코드 인식하세요.")
                    .initiateScan()
            } else {
                Toast.makeText(activity, "양식을 모두 채우시오.", LENGTH_SHORT).show()
            }
        }
        notificationsViewModel.personalData.observe(viewLifecycleOwner, {
            merit.text = it.Merit
        })
        return root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result: IntentResult =
            IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result.contents != null) {
            notificationsViewModel.setPersonalData(
                notificationsViewModel.requestData.value!!.name,
                result.contents,
                notificationsViewModel.requestData.value!!.grade,
                notificationsViewModel.requestData.value!!.ban,
                notificationsViewModel.requestData.value!!.num
            )
        }
    }

    private companion object {
        const val TAG = "NotificationsFragment"
    }
}