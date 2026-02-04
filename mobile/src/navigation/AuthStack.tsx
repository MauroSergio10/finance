import { createNativeStackNavigator } from '@react-navigation/native-stack';
import LoginScreen from '../screens/LoginScreen';
import CreateAccountScreen from '../screens/CreateAccountScreen';

export type RootStackParamList = {
  Login: undefined
  CreateAccount: undefined
};

const Stack = createNativeStackNavigator<RootStackParamList>();


export default function AuthStack() {
  return (
    <Stack.Navigator 
    initialRouteName="Login" 
    screenOptions={{ headerShown: false }}>
      
      <Stack.Screen 
        name="Login" 
        component={LoginScreen}
      />

      <Stack.Screen
        name="CreateAccount"
        component={CreateAccountScreen}
      />

    </Stack.Navigator>
  );
}
