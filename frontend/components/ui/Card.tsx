import { ReactNode } from "react";

export default function Card({ children }: { children: ReactNode } ) {
  return(
    <div 
      className="
        flex flex-col
        bg-slate-800 p-4
        rounded border border-slate-700
        shadow-md
      "
    >
      { children }
    </div>
  );
}