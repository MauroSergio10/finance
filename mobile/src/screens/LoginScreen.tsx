import React, { useState } from 'react';
import {
  View,
  Text,
  TouchableOpacity,
  StyleSheet,
  Alert,
} from 'react-native';
import { LinearGradient } from 'expo-linear-gradient';
import { InputField } from '../style/InputField';
import { KeyboardAwareScrollView } from 'react-native-keyboard-aware-scroll-view';
import { useAuth } from '../auth/AuthProvider';


export default function LoginScreen(){
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const {login} = useAuth()
  
  const handleLogin = async () => {
    if (!email || !password) {
      Alert.alert('Error', 'Please fill in all fields');
      return;
    }

    try{
      await login(email, password);
    }catch (err:any){
      Alert.alert("Error", err.message)
    }

    Alert.alert('Success', 'Login successful!');
    setIsLogged(true);
  };

  return (
    <KeyboardAwareScrollView
      contentContainerStyle={{ flex: 1}}
      enableOnAndroid>
      <LinearGradient
        colors={[
          '#020021',
          '#03094A',
          '#16132A',
          '#5B301E',
          '#A22300',
        ]}
        locations={[0, 0.29, 0.5, 0.74, 1]}
        start={{ x: 0, y: 0 }}
        end={{ x: 1, y: 1 }}
        style={styles.container}
      >
        <Text style={styles.title}>Welcome Back</Text>
        <Text style={styles.subtitle}>Sign in to continue</Text>

        <View style={styles.form}>
          <InputField
            icon="mail-outline"
            placeholder='Email'
            value={email}
            onChangeText={setEmail}
          />

          <InputField
            icon="lock-closed-outline"
            placeholder="Password"
            secureTextEntry
            value={password}
            onChangeText={setPassword}
          />

          <TouchableOpacity style={styles.button} onPress={handleLogin}>
            <Text style={styles.buttonText}>Login</Text>
          </TouchableOpacity>

          <TouchableOpacity
            style={styles.linkButton}
            onPress={() => navigation.navigate('CreateAccount')}
          >
            <Text style={styles.linkText}>
              Don't have an account? Sign Up
            </Text>
          </TouchableOpacity>
        </View>
      </LinearGradient>
    </KeyboardAwareScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 24,
    justifyContent: 'center',
  },
  title: {
    fontSize: 32,
    fontWeight: 'bold',
    color: '#ffffff',
    textAlign: 'center',
  },
  subtitle: {
    fontSize: 14,
    color: '#cccccc',
    textAlign: 'center',
    marginBottom: 40,
  },
  form: {
    backgroundColor: 'rgba(0,0,0,0.35)',
    padding: 20,
    borderRadius: 12,
  },

  button: {
    backgroundColor: '#22c55e',
    paddingVertical: 15,
    borderRadius: 8,
    alignItems: 'center',
    marginTop: 10,
    marginBottom: 15,
  },
  buttonText: {
    color: '#000000',
    fontSize: 16,
    fontWeight: '600',
  },
  linkButton: {
    alignItems: 'center',
  },
  linkText: {
    color: '#22c55e',
    fontSize: 14,
  },
});
