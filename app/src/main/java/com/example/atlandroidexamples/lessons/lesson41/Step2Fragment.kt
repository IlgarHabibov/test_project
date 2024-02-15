package com.example.atlandroidexamples.lessons.lesson41

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.atlandroidexamples.databinding.FragmentStep2Binding
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseException
import com.google.firebase.appcheck.FirebaseAppCheck
import com.google.firebase.appcheck.playintegrity.PlayIntegrityAppCheckProviderFactory
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import com.google.firebase.messaging.messaging
import com.google.firebase.remoteconfig.ConfigUpdate
import com.google.firebase.remoteconfig.ConfigUpdateListener
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.google.firebase.remoteconfig.remoteConfig
import java.util.concurrent.TimeUnit


class Step2Fragment : Fragment() {

    private lateinit var binding: FragmentStep2Binding
    private val personList = mutableListOf<PersonNew>()
    private val remoteConfig = Firebase.remoteConfig

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStep2Binding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Firebase.messaging.token.addOnCompleteListener {
            Log.d("MyPushServiceTAG", "token: ${it.result}")
        }

        binding.send.setOnClickListener {
//            sendText(binding.name.text.toString(), binding.surname.text.toString())
//            login()
            checkConfigs()
        }





        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 10
        }
        remoteConfig.setConfigSettingsAsync(configSettings)

//        remoteConfig.fetchAndActivate().addOnCompleteListener {
//            if(it.isSuccessful){
//                checkConfigs()
//            }
//        }


        remoteConfig.addOnConfigUpdateListener(object: ConfigUpdateListener{
            override fun onUpdate(configUpdate: ConfigUpdate) {
                checkConfigs()
            }

            override fun onError(error: FirebaseRemoteConfigException) {
                Log.d("RemoteConfigTAG", "error: $error")
            }

        })


        val db = Firebase.firestore

        db.collection("notes").addSnapshotListener { value, error ->
            value?.documents?.forEach {
                Log.d("FireStoreTag", "notes: ${it.data?.getValue("text")}")
            }

        }

        db.collection("students").addSnapshotListener { value, error ->
            value?.documents?.forEach {
                val person = it.toObject(PersonNew::class.java)
                person?.let { p ->
                    personList.add(p)
                }

                Log.d("FireStoreTag", "person: $person")
            }

        }
    }

    private fun checkConfigs(){
        remoteConfig.fetchAndActivate().addOnCompleteListener {
            if (it.isSuccessful){
                val a = remoteConfig.getBoolean("buttonShow")
                val b = remoteConfig.getLong("message")
                val c = remoteConfig.getValue("userData").asString()
                Log.d("RemoteConfigTAG", "buttonShow: $a")
                Log.d("RemoteConfigTAG", "message: $b")
                Log.d("RemoteConfigTAG", "userData: $c")

                binding.name.isVisible = a
            }
        }

    }

    private fun sendText(name: String, surname: String) {
        val db = Firebase.firestore
//        db.collection("students").add(
//            PersonNew(name, surname)
//        )

        db.collection("students")
            .document(name)
            .set(PersonNew(name, surname))
            .addOnSuccessListener {
                Toast.makeText(requireContext(), "$name added", Toast.LENGTH_SHORT).show()
            }

    }


    private fun login() {

        val auth = Firebase.auth
        val callback = object : OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                Log.d("FirebaseAuthTag", "onVerificationCompleted: ${p0.smsCode}")
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                Log.d("FirebaseAuthTag", "onVerificationFailed: ${p0.message}")
            }

        }

        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber("+994508766516") // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(requireActivity()) // Activity (for callback binding)
            .setCallbacks(callback) // OnVerificationStateChangedCallbacks
            .build()

        PhoneAuthProvider.verifyPhoneNumber(options)

    }


}