import { NavigationContainer } from '@react-navigation/native';
import { useState } from 'react';

import AuthStack from './AuthStack';
import AppStack from './AppStack';

export default function AppNavigation() {
  const [isLogged, setIsLogged] = useState(false);

  return (
    <NavigationContainer>
      {isLogged ? <AppStack setIsLogged={setIsLogged} /> : <AuthStack setIsLogged={setIsLogged} />}
    </NavigationContainer>
  );
}

