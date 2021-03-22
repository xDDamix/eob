package pl.dguziak.sharedresources.util

import android.content.res.Resources
import pl.dguziak.sharedresources.R

object StatusConverter {

    fun convertBooleanToStatus(resources: Resources, isCompleted: Boolean) =
        resources.getString(
            if (isCompleted)
                R.string.task_status_completed
            else
                R.string.task_status_pending
        )
}
