package pl.dguziak.detailsscreen.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import pl.dguziak.detailsscreen.databinding.FragmentDetailsScreenBinding
import pl.dguziak.view.fragment.BaseFragment

class DetailsScreenFragment : BaseFragment<FragmentDetailsScreenBinding>() {

    override val viewBindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailsScreenBinding =
        FragmentDetailsScreenBinding::inflate
}