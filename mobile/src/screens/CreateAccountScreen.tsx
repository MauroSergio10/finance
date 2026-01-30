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
import { supabase } from '../lib/supabase';


interface CreateAccountScreenProps {
  navigation: any;
  
}

export default function CreateAccountScreen({
  navigation,
}: CreateAccountScreenProps) {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');

  const handleCreateAccount = async ()  => {
    if (!email || !password || !confirmPassword) {
      Alert.alert('Error', 'Please fill in all fields');
      return;
    }

    if (password !== confirmPassword) {
      Alert.alert('Error', 'Passwords do not match');
      return;
    }

    const {data, error} = await supabase.auth.signUp({
      email,
      password
    });

    if(error){
      Alert.alert("Error", error.message);
      console.log(error.message);
      return;
    }

    console.log(data.session?.access_token);

    Alert.alert('Success', 'Account created successfully!');
    navigation.goBack();
  };

  return (
    <KeyboardAwareScrollView
      contentContainerStyle={{ flex: 1}}
      enableOnAndroid
    >
      <LinearGradient
      colors={[
        '#020021',
        '#03094A',
        '#16132A',
        '#5B301E',
        '#A22300',
      ]}
      locations={[0, 0.29, 0.5, 0.74, 1]}
      start={{x: 0, y:0}}
      end={{x:1, y:1}}
      style={styles.container}
      >
        <Text style={styles.title}>Create Account</Text>
        <Text style={styles.subtitle}>
          Create your account to get started
        </Text>


        <View style={styles.form}>
          <InputField
            icon="mail-outline"
            placeholder="Email"
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

          <InputField
            icon="lock-closed-outline"
            placeholder="Re-enter password"
            secureTextEntry
            value={confirmPassword}
            onChangeText={setConfirmPassword}
          />

          <TouchableOpacity style={styles.button} onPress={handleCreateAccount}>
            <Text style={styles.buttonText}>Create Account</Text>
          </TouchableOpacity>

          <TouchableOpacity onPress={() => navigation.goBack()}>
            <Text style={styles.linkText}>
              Already have an account? Sign In
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
    padding:25,
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
  linkText: {
    color: '#22c55e',
    fontSize: 14,
    textAlign: 'center',
  },
});
