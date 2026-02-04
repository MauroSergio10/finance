import { NavigationContainer } from '@react-navigation/native';
import AuthStack from './AuthStack';
import AppStack from './AppStack';
import { useAuth } from '../auth/AuthProvider';



export default function AppNavigation() {
  
  const {isLogged} = useAuth()


  return (
    <NavigationContainer>
      {isLogged ? <AppStack/> : <AuthStack/>}
    </NavigationContainer>
  );
}

