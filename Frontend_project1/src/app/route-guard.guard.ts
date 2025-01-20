import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';  // Import your auth service

@Injectable({
  providedIn: 'root'
})
export class RouteGuardGuard implements CanActivate {
  
  constructor(private authService: AuthService, private router: Router) {}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<boolean> | Promise<boolean> | boolean {
    // Check if the user is authenticated
    if (this.authService.isAuthenticated()) {
      return true; // Allow access to the route
    } else {
      this.router.navigate(['/login']); // Redirect to login if not authenticated
      return false; // Prevent access to the route
    }
  }
}
