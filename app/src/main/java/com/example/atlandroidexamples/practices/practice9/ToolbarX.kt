package com.example.atlandroidexamples.practices.practice9

import android.os.Bundle
import android.widget.Toolbar
import androidx.navigation.FloatingWindow
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import java.lang.ref.WeakReference
import java.util.regex.Pattern

class ToolbarOnDestinationChangedListener(toolbar: Toolbar) :
    NavController.OnDestinationChangedListener {
    private val toolbarWeakReference = WeakReference(toolbar)

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        if (toolbarWeakReference.get() == null) {
            controller.removeOnDestinationChangedListener(this)
            return
        }

        if (destination is FloatingWindow) {
            return
        }

        destination.label?.let {
            //val title = pickTitleFromArgs(it, arguments)
            setTitle(it)
        }
    }


    private fun setTitle(title: CharSequence) {
        toolbarWeakReference.get()?.let {
            it.title = title
        }
    }
}

fun Toolbar.setNavController(navController: NavController) {
    navController.addOnDestinationChangedListener(ToolbarOnDestinationChangedListener(this))
    this.setNavigationOnClickListener { navController.navigateUp() }
}