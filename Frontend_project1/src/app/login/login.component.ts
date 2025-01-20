import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';  // Import the AuthService

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginObj = {
    userName: '',
    password: ''
  };

  registerObj = {
    userName: '',
    email: '',
    password: ''
  };
  errorMessage: string | undefined;

  constructor(private authService: AuthService, private router: Router) {}

  // Login method
  onLogin() {
    const { userName, password } = this.loginObj; // Extract userName and password from loginObj
    const isAuthenticated = this.authService.login(userName, password);
    console.log(userName," -- ",password);
    if (isAuthenticated) {
      this.router.navigate(['/categories']);  // Redirect to categories after successful login
    } else {
      this.errorMessage = 'Invalid credentials, please try again.';
    }
  }
  onRegister() {
    // Register logic here
  }
    // Navigate to Categories Page
    gocategories() {
      console.log('Navigating to categories...');
      this.router.navigate(['/categories']);
    }
  
  
  
}
