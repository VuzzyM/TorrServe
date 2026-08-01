package ru.yourok.torrserve.ui.fragments.main.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.yourok.torrserve.R
import ru.yourok.torrserve.ui.fragments.TSFragment
import ru.yourok.torrserve.ui.fragments.main.torrents.TorrentsFragment

class CategoriesFragment : TSFragment() {

    private val categories = listOf(
        Category(
            R.string.category_all,
            "",
            R.drawable.round_view_list_24
        ),
        Category(
            R.string.category_movies,
            "movie",
            R.drawable.round_movie_24
        ),
        Category(
            R.string.category_series,
            "tv",
            R.drawable.round_live_tv_24
        ),
        Category(
            R.string.category_music,
            "music",
            R.drawable.round_music_note_24
        ),
        Category(
            R.string.category_other,
            "other",
            R.drawable.round_more_horiz_24
        ),
        Category(
            R.string.category_uncategorized,
            "uncategorized",
            R.drawable.round_uncategorized_24
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.categories_fragment,
            container,
            false
        )

        val recycler = view.findViewById<RecyclerView>(
            R.id.rvCategories
        )

        recycler.layoutManager =
            LinearLayoutManager(requireContext())

        recycler.adapter =
            CategoriesAdapter(categories) { category ->

                val fragment =
                    TorrentsFragment()

                fragment.arguments =
                    Bundle().apply {
                        putString(
                            "category",
                            category.value
                        )
                    }

                fragment.show(
                    requireActivity(),
                    R.id.container,
                    true
                )
            }

        return view
    }
}