import { createNativeStackNavigator } from '@react-navigation/native-stack';
import LoginScreen from '../screens/LoginScreen';
import CreateAccountScreen from '../screens/CreateAccountScreen';

const Stack = createNativeStackNavigator();

type AuthStackProps = {
  setIsLogged: React.Dispatch<React.SetStateAction<boolean>>
}

export default function AuthStack({ setIsLogged }: AuthStackProps) {
  return (
    <Stack.Navigator initialRouteName="Login">
      <Stack.Screen name="Login" options={{headerShown: false}}>
      {(props) => <LoginScreen {...props} setIsLogged={setIsLogged} />}
      </Stack.Screen>
      <Stack.Screen
        name="CreateAccount"
        component={CreateAccountScreen}
        options={{ headerShown: false }}
      />
    </Stack.Navigator>
  );
}
