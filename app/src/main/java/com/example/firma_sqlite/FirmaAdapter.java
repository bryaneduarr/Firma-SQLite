package com.example.firma_sqlite;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FirmaAdapter extends BaseAdapter {
  private Context context;
  private ArrayList<FirmaItem> photoItems;

  public FirmaAdapter(Context context, ArrayList<FirmaItem> photoItems) {
    this.context = context;
    this.photoItems = photoItems;
  }

  @Override
  public int getCount() {
    return photoItems.size();
  }

  @Override
  public Object getItem(int position) {
    return photoItems.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    if (convertView == null) {
      convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    ImageView imageView = convertView.findViewById(R.id.imageView);
    TextView descriptionView = convertView.findViewById(R.id.firmaView);

    FirmaItem photoItem = (FirmaItem) getItem(position);
    Bitmap imageBitmap = photoItem.getImageBitmap();
    String description = photoItem.getFirma();

    imageView.setImageBitmap(imageBitmap);
    descriptionView.setText(description);

    return convertView;
  }
}
