import React, { createContext, useContext, useEffect, useState } from "react";
import { supabase } from "../lib/supabase";

type AuthContexType= {
    isLogged: boolean;
    login: (email: string, password: string) => Promise<void>
    logout: () => Promise<void>
}

export const AuthContext = createContext<AuthContexType | null> (null);

export default function AuthProvider({children}: {children: React.ReactNode}){

    const [isLogged, setIsLogged] = useState(false);
    
    useEffect(() => {
        verifyDatabase();
        listenDatabase();
    }, []);

    //Verify if the user is logged
    const verifyDatabase = async () => {
        const { data } = await supabase.auth.getSession();
        setIsLogged(!!data.session);
    }

    //listen databasAPI changes
    const listenDatabase = async () => {
        const {data: {subscription}} =
        supabase.auth.onAuthStateChange((_, session) =>{
            setIsLogged(!!session);
        })

        return () => {
            subscription.unsubscribe()
        }
    }

    const login = async (email:string, password: string) => {
        const { error } = await supabase.auth.signInWithPassword({
            email,
            password
        })

        if(error){
            throw error
        }
    }

    const logout = async () => {
        await supabase.auth.signOut()
    }

    return(
        //Inject values for children
        <AuthContext.Provider value={{ isLogged, login, logout }}>
            {children}
        </AuthContext.Provider>
    )
}

export function useAuth(){
    const context = useContext(AuthContext)

    if (!context) throw new Error("useAuth must be used inside AuthProvider")

    return context;
}



