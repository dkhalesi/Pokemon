import { useRouter } from "next/router";
import styles from "../styles/Result.module.css";

const Result = () => {
  const router = useRouter();
  const result = router.query;

  return (
    <div className={styles.container}>
      <h1 className={styles.title}>Commentator's Notes</h1>
      {Object.entries(result).map(([key, value]) =>
        (() => {
          let classname = null;
          if (value.includes("Round")) {
            classname = styles.round;
          } else if (value.includes("Tournament")) {
            classname = styles.winner;
          } else {
            classname = null;
          }
          return <p className={classname}>{value}</p>;
        })()
      )}
    </div>
  );
};

export default Result;
