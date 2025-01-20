import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CartService, Order } from '../cart.service';
import { OrderItem,Address,Payment} from '../cart.service';



@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css'],
})

export class ProductsComponent {

  constructor(private router: Router,private cartService: CartService) {}

  cartItems: any[] = [];

  products = [
    { id: 1, title: 'STANDUP COMEDY', price: 300, imageUrl: 'assets/images/comedy.jpg', author: 'Judy Carter' },
    {
      id: 2,
      title: 'The Art Of Being Alone',
      price: 299,
      imageUrl: 'assets/images/book1.jpg',
      author: 'Renuka Gavrani',
    },
    {
      id: 3,
      title: 'The Art of Letting Go',
      price: 399,
      imageUrl: 'assets/images/book2.jpg',
      author: 'Nick Trenton',
    },
    {
      id: 4,
      title: 'Read people Like A Book',
      price: 199,
      imageUrl: 'assets/images/book3.jpg',
      author: 'Patrick King',
    },
  ];

  addToCart(product: any) {
    console.log('Product added to cart:', product);
    this.cartItems.push(product);
    const address: Address = {
      name: 'Ram',
      street: 'Kakinada',
      city: 'West Godavari',
      zip: '534101',
      country: 'India'
    };
    const payment: Payment = {
      method: 'Credit Card',
      cardNumber: '**** **** **** 1234',
      paymentStatus: 'Paid'
    };
    const order: Order = {
      id: 'R5TYGR6YIJ',
      date: this.cartService.getCurrentDate(),
      items: [],
      total: 0,
      address: address,
      payment: payment
    };
    this.cartService.setOrderDetails(order);
    this.cartService.setSharedArray(this.cartItems);
    this.router.navigate(['/cart']);
    // Implement cart addition logic here, e.g., calling a service or updating state
  }

  gocheckout() {
    console.log('Navigating to checkout...');
    this.router.navigate(['/checkout']);
  }
}
