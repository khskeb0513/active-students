package com.busanhs.active_students.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.busanhs.active_students.R

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val today1: TextView = root.findViewById(R.id.tv_dashboard_today1)
        val today2: TextView = root.findViewById(R.id.tv_dashboard_today2)
        val today3: TextView = root.findViewById(R.id.tv_dashboard_today3)
        val tomorrow1: TextView = root.findViewById(R.id.tv_dashboard_tomorrow1)
        val tomorrow2: TextView = root.findViewById(R.id.tv_dashboard_tomorrow2)
        val tomorrow3: TextView = root.findViewById(R.id.tv_dashboard_tomorrow3)
        val g1: TextView = root.findViewById(R.id.tv_dashboard_g1)
        val g2: TextView = root.findViewById(R.id.tv_dashboard_g2)
        dashboardViewModel.schoolTimeInfo.observe(viewLifecycleOwner, {
            g1.text = it.FirstINTime
            g2.text = it.SecondINTime
        })
        dashboardViewModel.mealInfo.observe(viewLifecycleOwner, {
            today1.text = if (it.today1.DDISH_NM.isNotEmpty()) it.today1.DDISH_NM.replace(
                "<br/>",
                "\n"
            ) else "등록된 급식 정보가 없습니다."
            today2.text = if (it.today2.DDISH_NM.isNotEmpty()) it.today2.DDISH_NM.replace(
                "<br/>",
                "\n"
            ) else "등록된 급식 정보가 없습니다."
            today3.text = if (it.today3.DDISH_NM.isNotEmpty()) it.today3.DDISH_NM.replace(
                "<br/>",
                "\n"
            ) else "등록된 급식 정보가 없습니다."
            tomorrow1.text = if (it.tomorrow1.DDISH_NM.isNotEmpty()) it.tomorrow1.DDISH_NM.replace(
                "<br/>",
                "\n"
            ) else "등록된 급식 정보가 없습니다."
            tomorrow2.text = if (it.tomorrow2.DDISH_NM.isNotEmpty()) it.tomorrow2.DDISH_NM.replace(
                "<br/>",
                "\n"
            ) else "등록된 급식 정보가 없습니다."
            tomorrow3.text = if (it.tomorrow3.DDISH_NM.isNotEmpty()) it.tomorrow3.DDISH_NM.replace(
                "<br/>",
                "\n"
            ) else "등록된 급식 정보가 없습니다."
        })
        return root
    }

    private companion object {
        const val TAG = "DashboardFragment"
    }
}