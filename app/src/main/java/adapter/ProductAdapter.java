package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fourthassignment.ProductDetails;
import com.fourthassignment.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import model.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>
{
    Context mContext;
    List<Product> productList;
    public ProductAdapter(Context mContext, List<Product> productList)
    {
        this.mContext = mContext;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_product,viewGroup,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, final int i) {
        final Product product = productList.get(i);
        productViewHolder.imgItem.setImageResource(product.getImageId());
        productViewHolder.tvItemName.setText(product.getProductname());
        productViewHolder.tvItemPrice.setText(product.getProductprice());

        productViewHolder.imgItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ProductDetails.class);

                intent.putExtra("id",product.getImageId());
                intent.putExtra("name",product.getProductname());
                intent.putExtra("price",product.getProductprice());
                intent.putExtra("description",product.getProductdescription());

                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{

        CircleImageView imgItem;
        TextView tvItemName, tvItemPrice,tvDescription;
        public ProductViewHolder(@NonNull View itemView){
            super(itemView);
            imgItem = itemView.findViewById(R.id.imgItem);
            tvItemName = itemView.findViewById(R.id.tvItemName);
            tvItemPrice = itemView.findViewById(R.id.tvItemPrice);
            tvDescription = itemView.findViewById(R.id.tvDescription);


        }
    }



}
