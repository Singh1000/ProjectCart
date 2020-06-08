import { Component, OnInit } from '@angular/core';
import { ShoppingCartService } from '../service/ShoppingCartService';
import { Product } from '../models/product';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {
    products: Product[] = [];

  constructor(private shoppingCartService: ShoppingCartService) { }

  ngOnInit(): void {
      this.loadProducts();
  }

loadProducts() {
        this.shoppingCartService.getAllProducts()
            .subscribe(
                (products: any[]) => {
                    this.products = products;
                },
                (error) => console.log(error)
            );
    }

}
