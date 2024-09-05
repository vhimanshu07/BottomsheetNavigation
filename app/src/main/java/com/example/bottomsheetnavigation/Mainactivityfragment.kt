package com.example.bottomsheetnavigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.bottomsheetnavigation.databinding.FragmentItemListDialogListDialogBinding
import com.example.bottomsheetnavigation.databinding.FragmentMainactivityfragmentBinding


/**
 * A simple [Fragment] subclass.
 * Use the [Mainactivityfragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Mainactivityfragment : Fragment() {

    private var _binding: FragmentMainactivityfragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onStop() {
        super.onStop()
        Log.d("Testing", "stop: mainactivity")
    }
    override fun onPause() {
        super.onPause()
        Log.d("Testing", "onPause: mainactivity")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentMainactivityfragmentBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button11.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_mainactivityfragment_to_itemListDialogFragment)
        }
        binding.button2.setOnClickListener {
           val bundle:Bundle= bundleOf("second" to true)
            arguments?.putBundle("First",bundle)
            findNavController().navigate(R.id.action_mainactivityfragment_to_itemListDialogFragment,arguments)
        }
    }


}