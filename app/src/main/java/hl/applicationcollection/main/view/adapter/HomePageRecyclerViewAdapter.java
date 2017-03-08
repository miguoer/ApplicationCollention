package hl.applicationcollection.main.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hl.applicationcollection.R;

/**
 * Created by huanglin on 2017/3/4.
 * 邮箱：1871767675@qq.com
 */

public class HomePageRecyclerViewAdapter extends RecyclerView.Adapter<HomePageRecyclerViewAdapter.HomePageRecyclerViewHolder>{


    private List<String> dataList;

    private Context context;

    public HomePageRecyclerViewAdapter(Context context, List<String> dataList) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public HomePageRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_page_recyclerview, parent, false);
        return new HomePageRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomePageRecyclerViewHolder holder, int position) {
        String iconName = dataList.get(position);
        holder.tvName.setText(iconName);
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    class HomePageRecyclerViewHolder extends RecyclerView.ViewHolder {
        /**
         * 图标
         */
        @BindView(R.id.ivItemHomePageRecyclerViewAdapter)
        ImageView ivIcon;

        /**
         * 名称
         */
        @BindView(R.id.tvItemHomePageRecyclerViewAdapter)
        TextView tvName;

        public HomePageRecyclerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
