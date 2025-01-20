import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {
  adminCredentials = {
    email: '',
    password: ''
  };
  errorMessage: string = '';  // To display error message if login fails
  isLoading: boolean = false;  // To show loading spinner while making API request
  service: any;

  constructor(private router: Router, private http:HttpClient) {}

  onLogin(): void {
    this.isLoading = true;  // Set loading state to true when the API request starts
    this.service.login(this.adminCredentials).subscribe(
      (response: { success: boolean }) => {
        // Handle successful login
        if (response.success) {
          alert('Login successful!');
          // Redirect to the admin dashboard
          this.router.navigate(['/adminDashboard']);
        }
      },
      (error: { error: { message: string } }) => {
        // Handle login failure
        this.errorMessage = error.error.message || 'Invalid credentials';
        this.isLoading = false;
      }
    );
  }
}
