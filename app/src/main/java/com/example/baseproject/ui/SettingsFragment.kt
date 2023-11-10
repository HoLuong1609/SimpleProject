package com.example.baseproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import com.example.baseproject.R
import com.example.baseproject.databinding.FragmentSettingsBinding
import java.util.Locale

class SettingsFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.menuContactUs.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.menuContactUs -> contactUs()
        }
    }

    private fun contactUs() {
        val subject = String.format(
            Locale.getDefault(),
            getString(R.string.subject_feedback_email),
            getString(R.string.app_name)
        )
        val addresses = arrayOf(getString(R.string.contact_email))
        startShareIntent(subject, addresses, null)
    }

    private fun startShareIntent(subject: String?, addresses: Array<String>?, text: String?) {
        val intentBuilder = ShareCompat.IntentBuilder(requireActivity())
        intentBuilder.setType("message/rfc822")
        addresses?.let {
            intentBuilder.setEmailTo(addresses)
        }
        subject?.let {
            intentBuilder.setSubject(it)
        }
        text?.let {
            intentBuilder.setText(it)
        }
        intentBuilder.startChooser()
    }

    companion object {

        fun newInstance(): SettingsFragment {
            return SettingsFragment()
        }
    }
}
