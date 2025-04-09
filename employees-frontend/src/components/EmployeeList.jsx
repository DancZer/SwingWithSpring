import React, { useEffect, useState } from "react";
import { Card, CardContent } from "@/components/ui/card";
import { Loader2 } from "lucide-react";

export default function EmployeeList() {
  const [employees, setEmployees] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetch(`${import.meta.env.VITE_API_URL}/employees`)
      .then((res) => res.json())
      .then((data) => {
		console.log("Fetched employees:", data);
        setEmployees(data);
        setLoading(false);
      })
      .catch((err) => {
        console.error("Error fetching employees:", err);
        setLoading(false);
      });
  }, []);

  if (loading) {
    return (
      <div className="flex justify-center items-center h-screen">
        <Loader2 className="animate-spin w-10 h-10" />
      </div>
    );
  }

  return (
    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4 p-6">
      {employees.map((employee, index) => (
        <Card key={index} className="shadow-xl rounded-2xl">
          <CardContent className="p-4">
            <h2 className="text-xl font-bold mb-2">{employee.name}</h2>
            <p className="text-gray-600">{employee.email}</p>
          </CardContent>
        </Card>
      ))}
    </div>
  );
}
