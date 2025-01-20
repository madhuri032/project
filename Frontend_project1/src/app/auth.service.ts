// src/app/auth.service.ts
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root', // This ensures the service is available globally
})
export class AuthService {

  constructor() {}

  // Method to log in a user
  login(userName: string, password: string): boolean {
    // You can replace this logic with your actual authentication logic (e.g., API call)
    if (userName === 'admin' && password === 'admin123') {
      localStorage.setItem('user', JSON.stringify({ userName }));
      return true;
    }
    return false;
  }

  // Method to check if a user is authenticated
  isAuthenticated(): boolean {
    return !!localStorage.getItem('user'); // Check if the user exists in local storage
  }

  // Method to log out a user
  logout(): void {
    localStorage.removeItem('user');
  }

  // Method to get the user's details (optional)
  getUserDetails() {
    return JSON.parse(localStorage.getItem('user') || '{}');
  }
}
