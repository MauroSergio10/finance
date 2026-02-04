import { createNativeStackNavigator } from '@react-navigation/native-stack';
import HomeScreen from '../screens/HomeScreen';
import CreateBankAccount from '../screens/CreateBankAccount';

type RootStackParamList = {
  Home: undefined,
  CreateBankAccount: undefined;
}

const Stack = createNativeStackNavigator<RootStackParamList>();

export default function AppStack() {
  return (
    <Stack.Navigator 
      screenOptions={{ headerShown: false }}
    >
      <Stack.Screen 
        name="Home"
        component={HomeScreen} 
      />

      <Stack.Screen
        name="CreateBankAccount"
        component={CreateBankAccount}
      />
    </Stack.Navigator>  
  );
}
