package pl.dguziak.navigateable

import androidx.fragment.app.Fragment

class FragmentChangeData (
    val fragment: Fragment,
    val transactionType: FragmentTransactionType,
    val withBackStack: Boolean = true
)