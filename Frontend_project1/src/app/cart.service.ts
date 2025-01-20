import { Injectable } from '@angular/core';

// Interface for Order Item (book details in this case)
export interface OrderItem {
  name: string;
  quantity: number;
  price: number;
  image: string;
}

// Interface for Payment Details
export interface Payment {
  method: 'Credit Card' | 'PayPal';  // Limiting payment methods to specific values
  cardNumber: '**** **** **** 1234';  // Masked card number
  paymentStatus: 'Paid' | 'Pending' | 'Failed';  // Payment status can be more descriptive
}

// Interface for Customer Address
export interface Address {
  name: 'Ram';
  street: 'Kakinada';
  city: 'West Godavari';
  zip: '534101';
  country: 'India';
}

// Interface for an Order
export interface Order {
  id: string;
  date: string;
  items: OrderItem[];
  total: number;
  address: Address;
  payment: Payment;
}

@Injectable({
  providedIn: 'root'  // Makes the service available across the application
})

export class CartService {
  ind: number = 0;
  private orders: Order[] = [];

  removeCartItem(index: number) {
    throw new Error('Method not implemented.');
  }
  updateCartItem(index: number, arg1: any) {
    throw new Error('Method not implemented.');
  }
  private cartItems: any[] = [];  // Holds the items added to the cart

  constructor() {}

  setTotalPrice(total: any){
    this.orders[0].total = total;
  }
  setOrderDetails(details: any){
    this.orders.push(details);
  }

  setSharedArray(data: any[]) {
    this.cartItems = data; // Update the array
    this.orders[0].items = data;
  }

  getSharedArray() {
    return this.cartItems; // Retrieve the array
  }

  setAddressArray(data: any) {
    this.orders[0].address = data; // Update the array
  }

  getAddressArray() {
    this.orders[0].address;
  }
  
  setPaymentsArray(data: any) {
    this.orders[0].payment = data;
  }

  // Adds an item to the cart
  addToCart(product: any) {
    this.cartItems.push(product);
    console.log(`${product.title} added to the cart!`);
  }

  // Returns the list of cart items
  getCartItems() {
    return this.cartItems;
  }

  // Clears the cart
  clearCart() {
    this.cartItems = [];
    console.log('Cart has been cleared.');
  }

  getOrders(){
    return this.orders;
  }

  // Removes an item from the cart (by its index or id)
  removeFromCart(index: number) {
    this.cartItems.splice(index, 1);
    console.log('Item removed from cart');
  }

  // Method to get the current date in ISO format (YYYY-MM-DD)
  getCurrentDate(): string {
    const today = new Date();
    return today.toISOString().split('T')[0]; // Format as YYYY-MM-DD
  }
  
}
