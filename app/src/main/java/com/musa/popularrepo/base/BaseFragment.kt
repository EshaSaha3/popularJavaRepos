package com.musa.popularrepo.base

import androidx.fragment.app.Fragment
import com.musa.popularrepo.MainActivity
import java.lang.IllegalStateException

abstract class BaseFragment : Fragment() {
    protected val mainActivity: MainActivity
        get() {
            return activity as? MainActivity ?: throw  IllegalStateException("Not attached!")
        }

}