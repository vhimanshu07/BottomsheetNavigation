package com.example.bottomsheetnavigation

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.bottomsheetnavigation.databinding.FragmentItemListDialogListDialogBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


/**
 *
 * A fragment that shows a list of items as a modal bottom sheet.
 *
 * You can show this modal bottom sheet from your activity like this:
 * <pre>
 *    ItemListDialogFragment.newInstance(30).show(supportFragmentManager, "dialog")
 * </pre>
 */
class ItemListDialogFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentItemListDialogListDialogBinding? = null
    private var act: AppCompatActivity? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    init {
        //  (dialog as BottomSheetDialog).behavior.state = BottomSheetBehavior.STATE_EXPANDED

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(context, "fragment1 oncreate", Toast.LENGTH_LONG)

        // not working
        //  act?.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
//        val inflater = TransitionInflater.from(requireContext())
//        enterTransition = inflater.inflateTransition(R.transition.slidein)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        Toast.makeText(context, "fragment1 oncreateview", Toast.LENGTH_LONG)
        _binding = FragmentItemListDialogListDialogBinding.inflate(inflater, container, false)

        val x = binding.root
        return x

    }

    override fun onStart() {
        super.onStart()
        Log.d("Testing", "start: one")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Testing", "stop: one")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Testing", "onPause: one")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Toast.makeText(context, "fragment1 onviewcreated", Toast.LENGTH_LONG)
        binding.backtofirst.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.gotonext.setOnClickListener {
            findNavController().navigate(R.id.action_itemListDialogFragment_to_itemListDialogFragment22)
        }
    }

    override fun onDestroyView() {
        Toast.makeText(context, "fragment1 ondestroyview", Toast.LENGTH_LONG)
        super.onDestroyView()
        _binding = null
        //Log.d("d","finished")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        act = context as AppCompatActivity
    }


    @SuppressLint("ResourceType")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

//        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
//        dialog.apply {
//                this.behavior.state=BottomSheetBehavior.STATE_EXPANDED
//                this.behavior.peekHeight= Resources.getSystem().displayMetrics.heightPixels
//        }
//        return dialog

        val bottomSheetDialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        bottomSheetDialog.setOnShowListener { dialog: DialogInterface? ->
            setupFullHeight(dialog as BottomSheetDialog)
        }
        return bottomSheetDialog
    }

//    val dialogc = dialog as BottomSheetDialog?
//    val b:FrameLayout= dialogc!!.findViewById<FrameLayout>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
//    // When using AndroidX the resource can be found at com.google.android.material.R.id.design_bottom_sheetFrameLayout bottomSheet =  dialogc.findViewById(android.support.design.R.id.design_bottom_sheet);
//    val bottomSheetBehavior: BottomSheetBehavior<*> =
//        BottomSheetBehavior.from(b)
//    dialogc.behavior.isFitToContents=false
//    bottomSheetBehavior.peekHeight =1000
//    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)

    private fun setupFullHeight(bottomSheetDialog: BottomSheetDialog) {
        val bottomSheet: FrameLayout =
            bottomSheetDialog.findViewById<FrameLayout>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
        val behavior: BottomSheetBehavior<*> = BottomSheetBehavior.from(bottomSheet)
        val layoutParams = bottomSheet.layoutParams
        val windowHeight = getWindowHeight()
        if (layoutParams != null) {
            layoutParams.height = (windowHeight * 0.8).toInt()
        }
        bottomSheet.layoutParams = layoutParams
        bottomSheetDialog.behavior.state = BottomSheetBehavior.STATE_COLLAPSED
        bottomSheetDialog.behavior.peekHeight = (windowHeight * 0.2).toInt()
    }

    private fun getWindowHeight(): Int {
        // Calculate window height for fullscreen use
        val displayMetrics = DisplayMetrics()
        (context as Activity?)!!.windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.heightPixels
    }

    // override fun getTheme(): Int =R.style.BaseBottomSheetDialog


}