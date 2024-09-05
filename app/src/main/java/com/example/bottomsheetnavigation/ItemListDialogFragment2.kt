package com.example.bottomsheetnavigation

import android.content.Context
import android.os.Bundle
import android.transition.TransitionInflater
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bottomsheetnavigation.databinding.FragmentItemListDialogListDialog2Binding

/**
 *
 * A fragment that shows a list of items as a modal bottom sheet.
 *
 * You can show this modal bottom sheet from your activity like this:
 * <pre>
 *    ItemListDialogFragment2.newInstance(30).show(supportFragmentManager, "dialog")
 * </pre>
 */
class ItemListDialogFragment2 : BottomSheetDialogFragment() {

    private var _binding: FragmentItemListDialogListDialog2Binding? = null
    private var act: AppCompatActivity?=null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(context,"fragment2 oncreate", Toast.LENGTH_LONG)
        // not working
       // act?.overridePendingTransition(R.anim.popup_enter,R.anim.popup_exit)

//        val inflater = TransitionInflater.from(requireContext())
//        exitTransition = inflater.inflateTransition(R.transition.fade)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(context,"fragment2 oncreateview", Toast.LENGTH_LONG)
        _binding = FragmentItemListDialogListDialog2Binding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Toast.makeText(context,"fragment2 onviewcreated", Toast.LENGTH_LONG)
        binding.backtofirsti.setOnClickListener {
            findNavController().popBackStack()
          //  findNavController().navigate(R.id.action_itemListDialogFragment2_to_itemListDialogFragment)
        }

    }
    override fun onDestroyView() {
        Toast.makeText(context,"fragment2 ondestroyview", Toast.LENGTH_LONG)
        super.onDestroyView()
        _binding = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        act=context as AppCompatActivity
    }
   // override fun getTheme(): Int =R.style.BaseBottomSheetDialog
}