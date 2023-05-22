package com.galacticstudio.parcialjoseguidos

import android.app.Application
import com.galacticstudio.parcialjoseguidos.data.lakes
import com.galacticstudio.parcialjoseguidos.repositories.LakeRepository

class LakeReviewerApplication: Application() {
    val lakeRepository: LakeRepository by lazy {
        LakeRepository(lakes)
    }
}