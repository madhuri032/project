import { Component } from '@angular/core';
import { CartService } from '../cart.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
})
export class CartComponent {
  cartItems: any[] = [];
  totalPrice: number = 0;

  constructor(private router: Router,private cartService: CartService) {
    this.cartItems = this.cartService.getCartItems(); // Load cart items
  }

  decreaseQuantity(index: number): void {
    if (this.cartItems[index].quantity > 1) {
      this.cartItems[index].quantity--;
      this.updateQuantity(index);
    }
  }

  increaseQuantity(index: number): void {
    this.cartItems[index].quantity++;
    this.updateQuantity(index);
  }

  updateQuantity(index: number): void {
    this.cartService.updateCartItem(index, this.cartItems[index]);
  }

  removeItem(index: number): void {
    this.cartItems.splice(index, 1);
    this.cartService.removeCartItem(index);
  }

  calculateTotalPrice(): number {
    this.totalPrice = this.cartItems.reduce((total, item) => total + item.price * item.quantity, 0);
    if(this.totalPrice){
    }else{
      this.cartItems[0].quantity = 1;
      this.totalPrice = this.cartItems[0].price;
    }
    this.cartService.setSharedArray(this.cartItems);
    this.cartService.setTotalPrice(this.totalPrice);
    return this.totalPrice;
  }

  checkout(): void {
    console.log('Proceeding to checkout...');
    // Implement checkout functionality
    this.router.navigate(['/checkout']);
  }
}
