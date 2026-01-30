import { createNativeStackNavigator } from '@react-navigation/native-stack';
import HomeScreen from '../screens/HomeScreen';
import { Dispatch } from 'react';

const Stack = createNativeStackNavigator();

type appStackProps = {
  setIsLogged: React.Dispatch<React.SetStateAction<boolean>>
}

export default function AppStack({ setIsLogged }: appStackProps ) {
  return (
    <Stack.Navigator>
      <Stack.Screen name="Home" options={{ headerShown: false }}>
      {(props) => <HomeScreen {...props} setIsLogged={setIsLogged}/>}
      </Stack.Screen>
    </Stack.Navigator>
  );
}
