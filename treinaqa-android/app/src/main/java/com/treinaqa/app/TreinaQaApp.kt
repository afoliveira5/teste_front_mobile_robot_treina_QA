package com.treinaqa.app

import android.app.Application

class TreinaQaApp : Application() {
    lateinit var repository: com.treinaqa.app.data.TreinaQaRepository
        private set

    override fun onCreate() {
        super.onCreate()
        repository = com.treinaqa.app.data.TreinaQaRepository(this)
    }
}
