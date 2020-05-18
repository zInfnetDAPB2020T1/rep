package com.example.projpaint3.Repositorio

import android.content.res.Resources
import com.example.projpaint3.R

class Repos{
    fun iconeIdToResource(iconeId : Int) : Int{
        when(iconeId){
            1 -> return R.drawable.avatar_1
            2 -> return R.drawable.avatar_2
            3 -> return R.drawable.avatar_3
            4 -> return R.drawable.avatar_4
            5 -> return R.drawable.avatar_5
            6 -> return R.drawable.avatar_6
            7 -> return R.drawable.avatar_7
            8 -> return R.drawable.avatar_8
            9 -> return R.drawable.avatar_9
            10 -> return R.drawable.avatar_10
            11 -> return R.drawable.avatar_11
            12 -> return R.drawable.avatar_12
            else -> return R.drawable.avatar_1
        }
    }
}