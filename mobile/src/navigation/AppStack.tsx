import { createNativeStackNavigator } from '@react-navigation/native-stack';
import HomeScreen from '../screens/HomeScreen';
import CreateBankAccount from '../screens/CreateBankAccount';

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
      <Stack.Screen
        name="CreateBankAccount"
        component={CreateBankAccount}
        options={{ headerShown: false }}
      />
    </Stack.Navigator>  
  );
}
