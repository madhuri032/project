import { Component } from '@angular/core';
import { CartService } from '../cart.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent {

  cartItems: any[] = [];
  
  constructor(private router: Router,private cartService: CartService) {
    this.cartItems = this.cartService.getCartItems(); // Load cart items
  }

  checkoutDetails = {
    name: '',
    email: '',
    address: '',
    paymentMethod: 'credit-card'
  };

  calculateTotalPrice() {
    return this.cartItems.reduce((total, item) => total + item.price * item.quantity, 0);
  }

  placeOrder() {
    if (this.checkoutDetails.name && this.checkoutDetails.email && this.checkoutDetails.address) {
      console.log('Order placed with details: ', this.checkoutDetails);
      alert('Order placed successfully!');
      this.router.navigate(['/order']);
    } else {
      alert('Please fill all fields before placing the order.');
    }
  }
}
