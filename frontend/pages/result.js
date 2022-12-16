import { useRouter } from "next/router";

const Result = () => {
  const router = useRouter();
  const result = router.query;

  return (
    <div>
      <h1>Commentator's Notes</h1>
      {Object.entries(result).map(([key, value]) => (
        <p>{value}</p>
      ))}
    </div>
  );
};

export default Result;
