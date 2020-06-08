import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class ShoppingCartService {
    private productsUrl = "/products";

    constructor(private http: HttpClient) {
    }

    getAllProducts() {
        return this.http.get(this.productsUrl);
    }

    // getters and setters for shared fields
}
