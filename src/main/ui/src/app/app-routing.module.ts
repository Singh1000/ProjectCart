import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { ShoppingCartService } from './shoppingcart/service/ShoppingCartService';


const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot(routes),  HttpClientModule],
  exports: [RouterModule],
  providers: [ShoppingCartService]
})
export class AppRoutingModule { }
