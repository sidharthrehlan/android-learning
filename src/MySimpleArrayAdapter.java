import java.util.List;

import android.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class MySimpleArrayAdapter extends ArrayAdapter<String> {
	  private final Context context;
	  private final String[] values;

	  public MySimpleArrayAdapter(Context context, String[] values) {
	    super(context, R.layout.simple_list_item_1, values);
	    this.context = context;
	    this.values = values;
	  }

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(android.R.layout.simple_list_item_2, parent, false);
		
		
		
		return super.getView(position, convertView, parent);
	}
	  
	  
	  
	  
 /*
	  @Override
	 public View getView(int position, View convertView, ViewGroup parent) {
	    LayoutInflater inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
	    TextView textView = (TextView) rowView.findViewById(R.id.label);
	    ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
	    textView.setText(values[position]);
	    // Change the icon for Windows and iPhone
	    String s = values[position];
	    if (s.startsWith("iPhone")) {
	      imageView.setImageResource(R.drawable.no);
	    } else {
	      imageView.setImageResource(R.drawable.ok);
	    }

	    return rowView;
	  }*/
	} 