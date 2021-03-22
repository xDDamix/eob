package pl.dguziak.view.fragment

import android.view.LayoutInflater
import android.view.ViewGroup

interface ViewBindingInflater<out VIEW_BINDING> {

    val viewBindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VIEW_BINDING
}
