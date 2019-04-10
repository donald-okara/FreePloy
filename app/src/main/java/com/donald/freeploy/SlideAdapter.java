package com.donald.freeploy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SlideAdapter(Context context){
        this.context= context;
    }

    //Arrays
    public int[] slide_images = {
        R.drawable.sleep,
       R.drawable.eat,
       R.drawable.socialize

    };

    public String[] slide_headings = {
            "SLEEP",
            "EAT",
            "SOCIALISE"

    };

    public String[] slide_descs = {
      "Lorem fdsjkdgaslkdjgadolwfgldjge;fkerg;fhg;dfh h u g ogo ugpipigtpidgff fgdffgfhgfkghshfrfg fggfgdfghdg",
      "Lorem fdsjkdgaslkdjgadolwfgldjge;fkerg;fhg;dfh h u g ogo ugpipigtpidgff fgdffgfhgfkghshfrfg fggfgdfghdg",
      "Lorem fdsjkdgaslkdjgadolwfgldjge;fkerg;fhg;dfh h u g ogo ugpipigtpidgff fgdffgfhgfkghshfrfg fggfgdfghdg"
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (ConstraintLayout) o;
    }

    @SuppressLint("ServiceCast")
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_images);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((ConstraintLayout)object);

    }
}
