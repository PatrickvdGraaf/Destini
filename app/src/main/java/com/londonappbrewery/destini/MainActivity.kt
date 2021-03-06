package com.londonappbrewery.destini

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private val mTextViewStory: TextView by bind(R.id.storyTextView)
    private val mButtonTop: Button by bind(R.id.buttonTop)
    private val mButtonBottom: Button by bind(R.id.buttonBottom)

    private var mStoryIndex: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mTextViewStory.setText(R.string.T1_Story)
        mButtonTop.setText(R.string.T1_Ans1)
        mButtonBottom.setText(R.string.T1_Ans2)

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener({
            when (mStoryIndex) {
                1, 2 -> {
                    mTextViewStory.setText(R.string.T3_Story)
                    mButtonTop.setText(R.string.T3_Ans1)
                    mButtonBottom.setText(R.string.T3_Ans2)
                    mStoryIndex = 3
                }
                3 -> {
                    mTextViewStory.setText(R.string.T6_End)
                    onEndReached()
                }
            }
        })

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener({
            when (mStoryIndex) {
                1 -> {
                    mTextViewStory.setText(R.string.T2_Story)
                    mButtonTop.setText(R.string.T2_Ans1)
                    mButtonBottom.setText(R.string.T2_Ans2)
                    mStoryIndex = 2
                }
                2 -> {
                    mTextViewStory.setText(R.string.T4_End)
                    onEndReached()
                }
                3 -> {
                    mTextViewStory.setText(R.string.T5_End)
                    onEndReached()
                }
            }
        })
    }

    private fun onEndReached() {
        mButtonTop.visibility = View.GONE
        mButtonBottom.visibility = View.GONE
    }

    private fun <T : View> MainActivity.bind(@IdRes res: Int): Lazy<T> =
            lazy(LazyThreadSafetyMode.NONE) { findViewById<T>(res) }
}
