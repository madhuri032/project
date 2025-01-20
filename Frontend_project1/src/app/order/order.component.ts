import { Component, OnInit } from '@angular/core';
import { CartService } from '../cart.service';
import { Router } from '@angular/router';


// Interface for Order Item (book details in this case)
interface OrderItem {
  name: string;
  quantity: number;
  price: number;
  image: string;
}

// Interface for Payment Details
interface Payment {
  method: 'Credit Card' | 'PayPal';  // Limiting payment methods to specific values
  cardNumber: string;  // Masked card number
  paymentStatus: 'Paid' | 'Pending' | 'Failed';  // Payment status can be more descriptive
}

// Interface for Customer Address
interface Address {
  name: string;
  street: string;
  city: string;
  zip: string;
  country: string;
}

// Interface for an Order
interface Order {
  id: string;
  date: string;
  items: OrderItem[];
  total: number;
  address: Address;
  payment: Payment;
}

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  // Declare the orders with the defined Order type
  orders: Order[] = [];

  constructor(private router: Router,private cartService: CartService) {
    this.orders = this.cartService.getOrders();
  };

  ngOnInit(): void {
    // Initialization logic (can be used to fetch real order data from a server)
    console.log('Order data loaded:', this.orders);
  }

  // Method to get the current date in ISO format (YYYY-MM-DD)
  getCurrentDate(): string {
    const today = new Date();
    return today.toISOString().split('T')[0]; // Format as YYYY-MM-DD
  }
}
