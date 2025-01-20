import { Component } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-logout',
  standalone:false,
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent {
  constructor(private router: Router) {}

  logout(): void {
    // Clear user session or authentication token
    localStorage.removeItem('userToken'); // Example: Remove stored token
    alert('You have successfully logged out!');
    this.router.navigate(['/login']); // Redirect to login or home page
  }

  cancel(): void {
    // Navigate back to the previous or home page
    this.router.navigate(['/']);
  }
}
