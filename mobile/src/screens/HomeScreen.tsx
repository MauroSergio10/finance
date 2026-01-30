import React, { useEffect, useState } from 'react';
import { supabase } from '../lib/supabase';
import { 
  View, 
  Text, 
  TouchableOpacity, 
  StyleSheet 
} from 'react-native';

type HomeScreenProps = {
  navigation: any,
  setIsLogged: React.Dispatch<React.SetStateAction<boolean>>
}

export default function HomeScreen({ setIsLogged, navigation }: HomeScreenProps) {
  const handleLogout = () => {
    supabase.auth.signOut();
    setIsLogged(false);
  };

  const [accounts, setAccounts] = useState<any[]>([])
  const [total, setTotal] = useState(0);


  useEffect(() => {
    loadAccounts();
  }, []);

  const loadAccounts = async () => {
    const { data } = await supabase.auth.getSession();
    const token = data.session?.access_token; 

    if (!token) return;

    const response = await fetch("http://10.198.177.150:8080/account",{
      headers: {
        Authorization: `Bearer ${token}`
      }
    });

    const list = await response.json();
    setAccounts(list);

    const sum = list.reduce(
      (s:number, acc: any) => acc.balance,
      0
    );

    setTotal(sum);
  }

  return (
    <View style={styles.container}>
      <Text>
        {`Saldo: ${total}`}
      </Text>
      <Text style={styles.title}>Welcome to Finance App!</Text>
      <Text style={styles.subtitle}>You are successfully logged in</Text>
      
      <View style={styles.content}>
        <Text style={styles.description}>
          This is your home screen. You can now start building your finance features here.
        </Text>
        
        <TouchableOpacity style={styles.logoutButton} onPress={handleLogout}>
          <Text style={styles.logoutButtonText}>Logout</Text>
        </TouchableOpacity>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    paddingHorizontal: 20,
    backgroundColor: '#fff',
  },
  title: {
    fontSize: 28,
    fontWeight: 'bold',
    textAlign: 'center',
    marginBottom: 10,
    color: '#333',
  },
  subtitle: {
    fontSize: 16,
    textAlign: 'center',
    marginBottom: 30,
    color: '#666',
  },
  content: {
    alignItems: 'center',
  },
  description: {
    fontSize: 14,
    textAlign: 'center',
    lineHeight: 20,
    color: '#666',
    marginBottom: 30,
  },
  logoutButton: {
    backgroundColor: '#FF3B30',
    paddingVertical: 12,
    paddingHorizontal: 30,
    borderRadius: 8,
    alignItems: 'center',
  },
  logoutButtonText: {
    color: '#fff',
    fontSize: 16,
    fontWeight: '600',
  },
});