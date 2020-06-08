import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ShoppingcartComponent } from './shoppingcart/shoppingcart.component';
import { ProductsComponent } from './shoppingcart/products/products.component';

@NgModule({
  declarations: [
    AppComponent,
    ShoppingcartComponent,
    ProductsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
