package com.busanhs.active_students.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.busanhs.active_students.R
import com.busanhs.active_students.api.RetrofitService

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val location: TextView = root.findViewById(R.id.tv_home_gongsi_contents)
        homeViewModel.schoolInfo.observe(viewLifecycleOwner, {
            location.text = makeText(it)
        })
        return root
    }

    private fun makeText(schoolInfo: RetrofitService.SchoolInfo): String {
        return "우리 부산고등학교는 ${schoolInfo.ATPT_OFCDC_SC_NM} 소속이며, ${schoolInfo.ORG_RDNMA} 에 위치하고 있습니다.\n" +
                "또한, ${schoolInfo.HS_GNRL_BUSNS_SC_NM} ${schoolInfo.FOND_SC_NM}고등학교이며, ${schoolInfo.COEDU_SC_NM}고등학교입니다.\n" +
                "전화번호는 ${schoolInfo.ORG_TELNO} 이며, 자세한 사항은 홈페이지 (${schoolInfo.HMPG_ADRES})를 참조 바랍니다.\n" +
                "감사합니다."
    }
}