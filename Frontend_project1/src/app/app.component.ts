import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'project1';
  isLogin: boolean = true;  // To toggle between login and register forms
  loginObj = { userName: '', password: '' };
  registerObj = { userName: '', email: '', password: '' };

  toggleForm(isLogin: boolean) {
    this.isLogin = isLogin;
  }

  onLogin() {
    console.log('Login successful', this.loginObj);
    // Here, you can handle the login logic like sending data to backend
  }

  onRegister() {
    console.log('Registration successful', this.registerObj);
  }
}
