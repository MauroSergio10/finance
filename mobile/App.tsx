import { AuthProvider } from  './src/auth/AuthProvider'
import AppNavigation from './src/navigation/AppNavigation';

export default function App() {
  return (
    <AuthProvider>
      <AppNavigation />
    </AuthProvider>
  );
}
